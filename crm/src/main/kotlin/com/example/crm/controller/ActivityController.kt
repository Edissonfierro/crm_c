package com.example.crm.controller

import com.example.crm.entity.ActivityEntity
import com.example.crm.service.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/activities")
class ActivityController @Autowired constructor(
    private val activityService: ActivityService
) {

    @GetMapping
    fun getActivities(): List<ActivityEntity> = activityService.getActivities()

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Long): ActivityEntity? = activityService.getActivityById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createActivity(@RequestBody activity: ActivityEntity): ActivityEntity = activityService.createActivity(activity)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteActivity(@PathVariable id: Long) {
        if (!activityService.deleteActivity(id)) {
            throw RuntimeException("Activity not found")
        }
    }

    @GetMapping("/leads/{leadId}")
    fun getActivitiesForLead(@PathVariable leadId: Long): List<ActivityEntity> =
        activityService.getActivitiesForLead(leadId)
}
