import {useState} from 'react'
export default function BookingModal({decorator,searchData,onClose,onSubmit,submitting}){
 const [form,setForm]=useState({customerName:'',phone:'',email:'',eventType:searchData.eventType,location:searchData.location,eventDate:searchData.eventDate,budget:searchData.budget,service:searchData.service,decoratorId:decorator.id,paymentMethod:'UPI',notes:''})
 const update=e=>setForm({...form,[e.target.name]:e.target.value})
 return <div className="modal-backdrop" onMouseDown={e=>e.target===e.currentTarget&&onClose()}><div className="modal">
  <button className="close-btn" onClick={onClose}>×</button><h2>Book {decorator.businessName}</h2><p className="muted">Send your booking request.</p>
  <form className="booking-form" onSubmit={e=>{e.preventDefault();onSubmit(form)}}>
   <div className="two-col"><div className="field"><label>Your Name *</label><input name="customerName" value={form.customerName} onChange={update} required/></div>
   <div className="field"><label>Phone *</label><input name="phone" value={form.phone} onChange={update} pattern="[6-9][0-9]{9}" required/></div></div>
   <div className="two-col"><div className="field"><label>Email</label><input type="email" name="email" value={form.email} onChange={update}/></div>
   <div className="field"><label>Event Date *</label><input type="date" name="eventDate" value={form.eventDate} onChange={update} required/></div></div>
   <div className="two-col"><div className="field"><label>Location *</label><input name="location" value={form.location} onChange={update} required/></div>
   <div className="field"><label>Budget ₹ *</label><input type="number" name="budget" value={form.budget} min="1000" onChange={update} required/></div></div>
   <div className="field"><label>Payment Method *</label><div className="payment-options">{['UPI','Card','Cash'].map(m=><label className={'payment-option '+(form.paymentMethod===m?'selected':'')} key={m}><input type="radio" name="paymentMethod" value={m} checked={form.paymentMethod===m} onChange={update}/>{m==='UPI'?'📱':m==='Card'?'💳':'💵'} {m}</label>)}</div></div>
   <div className="field"><label>Additional Notes</label><textarea name="notes" value={form.notes} onChange={update} rows="3" placeholder="Theme, flowers, stage size..."/></div>
   <button className="primary-btn full-btn" disabled={submitting}>{submitting?'Submitting...':'✓ Confirm Booking Request'}</button>
  </form>
 </div></div>
}
