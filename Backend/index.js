const { db } = require('./data.js');
const express = require("express");

const app = express();
const port = 3100;

app.use(express.json());

app.listen(port, () => {
    console.log("Servidor escuchando en http://localhost:" + port);
});

// ── Ping ─────────────────────────────────────────────────────────────────────
app.get('/', (req, res) => {
    res.json({ mensaje: 'Running app!' });
});

// ── Miembros ──────────────────────────────────────────────────────────────────
// GET /miembros — todos
app.get('/miembros', (req, res) => {
    res.json(db.miembros);
});

// GET /miembros/:id — uno por id
app.get('/miembros/:id', (req, res) => {
    const miembro = db.miembros.find(m => m.id_miembro === parseInt(req.params.id));
    if (!miembro) return res.status(404).json({ error: 'Miembro no encontrado' });
    res.json(miembro);
});

// GET /miembros/aportantes — solo los que han aportado (sin duplicados)
app.get('/miembros/aportantes', (req, res) => {
    const ids = [...new Set(db.aportes.map(a => a.miembroId))];
    res.json(db.miembros.filter(m => ids.includes(m.id_miembro)));
});

// ── Metas ─────────────────────────────────────────────────────────────────────
// GET /metas — todas
app.get('/metas', (req, res) => {
    res.json(db.metas);
});

// GET /metas/:id — una por id
app.get('/metas/:id', (req, res) => {
    const meta = db.metas.find(m => m.id === parseInt(req.params.id));
    if (!meta) return res.status(404).json({ error: 'Meta no encontrada' });
    res.json(meta);
});

// ── Aportes ───────────────────────────────────────────────────────────────────
// GET /aportes — todos
app.get('/aportes', (req, res) => {
    res.json(db.aportes);
});

// GET /aportes/meta/:metaId — aportes de una meta específica
app.get('/aportes/meta/:metaId', (req, res) => {
    res.json(db.aportes.filter(a => a.metaId === parseInt(req.params.metaId)));
});

// GET /aportes/miembro/:miembroId — aportes de un miembro específico
app.get('/aportes/miembro/:miembroId', (req, res) => {
    res.json(db.aportes.filter(a => a.miembroId === parseInt(req.params.miembroId)));
});

// GET /aportes/meta/:metaId/total — suma de aportes confirmados de una meta
app.get('/aportes/meta/:metaId/total', (req, res) => {
    const total = db.aportes
        .filter(a => a.metaId === parseInt(req.params.metaId) && a.estado === 'confirmado')
        .reduce((sum, a) => sum + a.monto, 0);
    res.json({ metaId: parseInt(req.params.metaId), total });
});
