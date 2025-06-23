db = db.getSiblingDB(process.env.CLASSES_DATABASE); // Replace 'your_database_name' with your actual database name

db.createUser({
    user: process.env.CLASSES_USERNAME, // Replace with your desired username
    pwd: process.env.CLASSES_PASSWORD, // Replace with your desired password
    roles: [
        { role: 'readWrite', db: process.env.CLASSES_DATABASE } // Or other roles as needed
    ]
});
