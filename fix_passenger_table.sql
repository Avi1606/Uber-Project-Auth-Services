-- Quick fix script to add missing columns to passenger table
-- Run this in pgAdmin or psql

-- Add email column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS email VARCHAR(255) DEFAULT '' NOT NULL;

-- Add password column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS password VARCHAR(255) DEFAULT '' NOT NULL;

-- Add phonenumber column
ALTER TABLE passenger ADD COLUMN IF NOT EXISTS phonenumber VARCHAR(255) DEFAULT '' NOT NULL;

-- Make name NOT NULL if it isn't already
UPDATE passenger SET name = '' WHERE name IS NULL;
ALTER TABLE passenger ALTER COLUMN name SET NOT NULL;

-- Verify the changes
SELECT column_name, data_type, is_nullable
FROM information_schema.columns
WHERE table_name = 'passenger'
ORDER BY ordinal_position;

