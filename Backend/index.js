const { db } = require('./data.js');
const express = require("express");

const app = express();
const port = 3100;

/*Todos los datos se convierten a json */
app.use(express.json());

app.listen(port, () =>{
    console.log("Servidor de node escuchando en http://localhost:"+port);
});

/*req:datos que envia el usuario, res: datos que se responde*/
app.get('/', (req, res) => {
  res.json({
    mensaje: 'Running app!'
  })
})

// Obtener todos los miembros que han aportado (sin duplicados)
app.get('/miembros/aportantes', (req, res) => {
  const miembroIds = [...new Set(db.aportes.map(a => a.miembroId))];
  const miembros = db.miembros.filter(m => miembroIds.includes(m.id_miembro));
  res.send(miembros);
});