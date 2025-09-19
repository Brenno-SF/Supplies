CREATE TABLE tb_fuel(
    fuel_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    price NUMERIC(10, 2) NOT NULL
);
CREATE TABLE tb_pump(
    pump_id SERIAL PRIMARY KEY,
    fuel_id_fk INT NOT NULL,
    name VARCHAR(100),
    CONSTRAINT fk_fuel_pump FOREIGN KEY (fuel_id_fk) REFERENCES tb_fuel(fuel_id)
);
CREATE TABLE tb_supply(
    supply_id SERIAL PRIMARY KEY,
    pump_id_fk INT NOT NULL,
    name VARCHAR(100),
    price NUMERIC(10, 2) NOT NULL,
    liter NUMERIC(10, 3) NOT NULL,
    total NUMERIC(10, 2) NOT NULL,
    date_supply TIMESTAMP NOT NULL,
    CONSTRAINT fk_pump_supply FOREIGN KEY (pump_id_fk) REFERENCES tb_pump(pump_id)
);

