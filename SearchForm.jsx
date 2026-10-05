import {useState} from 'react'
const initial={eventType:'Wedding',location:'Nellore',eventDate:'',budget:50000,service:'Stage Decoration'}
export default function SearchForm({onSearch,loading}){
 const [form,setForm]=useState(initial)
 const update=e=>setForm({...form,[e.target.name]:e.target.value})
 return <form className="search-form" onSubmit={e=>{e.preventDefault();onSearch(form)}}>
  <div className="field"><label>Event Type</label><select name="eventType" value={form.eventType} onChange={update}>
   {['Wedding','Birthday','Engagement','Reception','Anniversary','Corporate'].map(x=><option key={x}>{x}</option>)}</select></div>
  <div className="field"><label>Location</label><input name="location" value={form.location} onChange={update} required placeholder="e.g. Nellore"/></div>
  <div className="field"><label>Event Date</label><input type="date" name="eventDate" value={form.eventDate} onChange={update} required/></div>
  <div className="field"><label>Maximum Budget (₹)</label><input type="number" name="budget" value={form.budget} min="1000" onChange={update} required/></div>
  <div className="field"><label>Required Service</label><select name="service" value={form.service} onChange={update}>
   {['Stage Decoration','Floral','Balloon','Lighting','Wedding Theme','Corporate'].map(x=><option key={x}>{x}</option>)}</select></div>
  <button className="primary-btn search-btn" disabled={loading}>{loading?'Finding...':'🔎 Find Matching Decorators'}</button>
 </form>
}
