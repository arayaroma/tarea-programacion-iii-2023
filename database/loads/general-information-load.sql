INSERT INTO EVACOMUNA."TBL_GENERAL_INFORMATION" (
    "ID",
    "NAME",
    "EMAIL",
    "PHOTO",
    "HTMLTEMPLATE",
    "VERSION"
) VALUES (
    '1',
    'EvaComUNA',
    'evacomuna@gmail.com',
    EMPTY_BLOB(),
    '<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Registration Successful</title>
  </head>
  <body
    style="
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #f4f4f4;
    "
  >
    <div
      style="
        max-width: 600px;
        margin: 0 auto;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      "
    >
      <h1 style="color: #333">[title]</h1>
      <h2 style="color: #444">[header]</h2>
      <p style="color: #666">Dear [user_name],</p>
      <p style="color: #666">[body]</p>

      <p style="color: #666">[footer]</p>

      <p style="color: #666">Best regards,</p>
      <p style="color: #333"><strong>The [team] Team</strong></p>

      <p style="text-align: center; color: #999; font-size: 12px">
        This is an automated email. Please do not reply.
      </p>
    </div>
  </body>
</html>',
    '1'
);