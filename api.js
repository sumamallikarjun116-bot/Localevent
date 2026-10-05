import axios from 'axios'
const api=axios.create({baseURL:'http://localhost:8080/api',headers:{'Content-Type':'application/json'}})
export const searchDecorators=async(params)=>(await api.get('/decorators/search',{params})).data
export const createBooking=async(data)=>(await api.post('/bookings',data)).data
