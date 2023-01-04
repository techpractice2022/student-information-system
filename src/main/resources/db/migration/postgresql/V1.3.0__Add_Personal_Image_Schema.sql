DROP TABLE IF EXISTS personal_image;

CREATE TABLE personal_image(
      id INT8,
        name VARCHAR(255),
         type VARCHAR(255),
         imagedata OID,

      PRIMARY KEY (id));
