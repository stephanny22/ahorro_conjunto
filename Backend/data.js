const db = {
  miembros: [
    { id_miembro: 1, Nombre: "Carlos Ramírez", fechaCreacion: "2024-01-10" },
    { id_miembro: 2, Nombre: "Laura Gómez",    fechaCreacion: "2024-01-15" },
    { id_miembro: 3, Nombre: "Andrés Torres",  fechaCreacion: "2024-02-01" }
  ],

  metas: [
    {
      id: 1,
      nombre: "Viaje a Cartagena",
      descripcion: "Juntar para el viaje de mitad de año",
      valor_total: 5000000,
      fechaObjetivo: "2024-07-01",
      ubicacionImagen: "/images/cartagena.jpg",
      estado: "activa",
      fechaCreacion: "2024-01-20"
    },
    {
      id: 2,
      nombre: "Fondo de emergencias",
      descripcion: "Reserva para imprevistos del grupo",
      valor_total: 2000000,
      fechaObjetivo: "2024-12-31",
      ubicacionImagen: "/images/emergencias.jpg",
      estado: "activa",
      fechaCreacion: "2024-02-05"
    }
  ],

  meta_miembro: [
    { id: 1, metaId: 1, miembroId: 1, fechaUnion: "2024-01-20" },
    { id: 2, metaId: 1, miembroId: 2, fechaUnion: "2024-01-21" },
    { id: 3, metaId: 1, miembroId: 3, fechaUnion: "2024-01-22" },
    { id: 4, metaId: 2, miembroId: 1, fechaUnion: "2024-02-05" },
    { id: 5, metaId: 2, miembroId: 2, fechaUnion: "2024-02-06" }
  ],

  aportes: [
    {
      id: 1,
      metaId: 1,
      miembroId: 1,
      monto: 500000,
      metodoPago: "transferencia",
      descripcion: "Primer aporte viaje",
      fecha: "2024-02-01",
      estado: "confirmado"
    },
    {
      id: 2,
      metaId: 1,
      miembroId: 2,
      monto: 300000,
      metodoPago: "efectivo",
      descripcion: "Aporte inicial Laura",
      fecha: "2024-02-03",
      estado: "confirmado"
    },
    {
      id: 3,
      metaId: 1,
      miembroId: 3,
      monto: 200000,
      metodoPago: "nequi",
      descripcion: "Cuota Andrés",
      fecha: "2024-02-10",
      estado: "pendiente"
    },
    {
      id: 4,
      metaId: 2,
      miembroId: 1,
      monto: 100000,
      metodoPago: "transferencia",
      descripcion: "Aporte fondo emergencias",
      fecha: "2024-02-15",
      estado: "confirmado"
    },
    {
      id: 5,
      metaId: 2,
      miembroId: 2,
      monto: 150000,
      metodoPago: "daviplata",
      descripcion: "Aporte Laura fondo",
      fecha: "2024-02-20",
      estado: "confirmado"
    }
  ]
}
module.exports = { db };