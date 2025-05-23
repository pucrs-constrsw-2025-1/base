// backend/utils/mongodb/init/seed.js
// Ao iniciar, o entrypoint define "db" -> "test".
// Troque explicitamente para o database da aplicação.
db = db.getSiblingDB('constrsw');

db.publications.insertMany([
  {
    _id: UUID("cde121ba-9224-4f21-990a-d52999a3b8c6"),
    title: "Data Science from Scratch",
    type: "Livro",
    publishedBy: "O'Reilly",
    url: "https://www.oreilly.com/library/view/data-science-from/9781492041122/"
  }
]);

db.courses.insertOne({
  _id: UUID("b7f3a321-4d3e-44d6-9c34-91a0b0f2f5d2"),
  name: "Introdução à Ciência de Dados",
  description: "Curso introdutório…",
  credit: 4,
  requirements: [],
  bibliography: []
});