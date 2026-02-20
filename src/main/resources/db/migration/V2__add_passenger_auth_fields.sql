-- Add email column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS email VARCHAR(255);

-- Add password column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS password VARCHAR(255);

-- Add phonenumber column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS phonenumber VARCHAR(255);

-- Update existing rows with default values
UPDATE passenger SET email = COALESCE(email, '') WHERE email IS NULL;
UPDATE passenger SET password = COALESCE(password, '') WHERE password IS NULL;
UPDATE passenger SET phonenumber = COALESCE(phonenumber, '') WHERE phonenumber IS NULL;

-- Add NOT NULL constraints only if columns are nullable
DO $$
BEGIN
    -- Set email as NOT NULL
    IF EXISTS (SELECT 1 FROM information_schema.columns
               WHERE table_name='passenger' AND column_name='email' AND is_nullable='YES') THEN
        ALTER TABLE passenger ALTER COLUMN email SET NOT NULL;
    END IF;

    -- Set password as NOT NULL
    IF EXISTS (SELECT 1 FROM information_schema.columns
               WHERE table_name='passenger' AND column_name='password' AND is_nullable='YES') THEN
        ALTER TABLE passenger ALTER COLUMN password SET NOT NULL;
    END IF;

    -- Set phonenumber as NOT NULL
    IF EXISTS (SELECT 1 FROM information_schema.columns
               WHERE table_name='passenger' AND column_name='phonenumber' AND is_nullable='YES') THEN
        ALTER TABLE passenger ALTER COLUMN phonenumber SET NOT NULL;
    END IF;

    -- Set name as NOT NULL
    IF EXISTS (SELECT 1 FROM information_schema.columns
               WHERE table_name='passenger' AND column_name='name' AND is_nullable='YES') THEN
        ALTER TABLE passenger ALTER COLUMN name SET NOT NULL;
    END IF;
END $$;

