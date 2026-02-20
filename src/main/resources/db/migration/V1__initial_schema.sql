-- Add email column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS email VARCHAR(255);

-- Add password column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS password VARCHAR(255);

-- Add phonenumber column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS phonenumber VARCHAR(255);

-- Update existing rows with default values
UPDATE passenger SET email = '' WHERE email IS NULL;
UPDATE passenger SET password = '' WHERE password IS NULL;
UPDATE passenger SET phonenumber = '' WHERE phonenumber IS NULL;

-- Add NOT NULL constraints
ALTER TABLE passenger ALTER COLUMN email SET NOT NULL;
ALTER TABLE passenger ALTER COLUMN password SET NOT NULL;
ALTER TABLE passenger ALTER COLUMN phonenumber SET NOT NULL;
ALTER TABLE passenger ALTER COLUMN name SET NOT NULL;
