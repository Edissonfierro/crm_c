CREATE TABLE IF NOT EXISTS lead (
                                    id SERIAL PRIMARY KEY,
                                    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(255),
    status VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS activity (
    id SERIAL PRIMARY KEY,
    lead_id BIGINT NOT NULL,
    activity_type VARCHAR(255),
    activity_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    notes TEXT,
    FOREIGN KEY (lead_id) REFERENCES lead(id)
    );