CREATE TABLE IF NOT EXISTS car
(
    id SERIAL PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year_of_issue INTEGER,
    engine_capacity DOUBLE PRECISION,
    mileage INTEGER,
    price INTEGER NOT NULL,
    deleted_car BOOLEAN
)


