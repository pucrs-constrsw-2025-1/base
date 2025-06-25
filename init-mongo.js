// Script de inicialização do MongoDB
// Cria databases para cada serviço usando o usuário admin existente

// Para o serviço classes
db = db.getSiblingDB('classes');
// Cria uma coleção para garantir que o database seja criado
db.createCollection('classes');

// Para o serviço courses
db = db.getSiblingDB('courses');
db.createCollection('courses');

// Para o serviço lessons
db = db.getSiblingDB('lessons');
db.createCollection('lessons');

// Para o serviço professors
db = db.getSiblingDB('professors');
db.createCollection('professors');

// Para o serviço reservations
db = db.getSiblingDB('reservations');
db.createCollection('reservations');

// Para o serviço resources
db = db.getSiblingDB('resources');
db.createCollection('resources');

// Para o serviço rooms
db = db.getSiblingDB('rooms');
db.createCollection('rooms');

// Para o serviço students
db = db.getSiblingDB('students');
db.createCollection('students');

print('Todos os databases foram criados com sucesso!');
print('Databases criados: classes, courses, lessons, professors, reservations, resources, rooms, students');
