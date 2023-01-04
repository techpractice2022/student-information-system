ALTER TABLE student_personal_information
ALTER COLUMN Image TYPE VARCHAR(255)
USING Image::VARCHAR(255);