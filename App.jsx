import {useState} from 'react'
import {searchDecorators,createBooking} from './services/api'
import SearchForm from './components/SearchForm'
import DecoratorCard from './components/DecoratorCard'
import BookingModal from './components/BookingModal'

export default function App(){
 const [decorators,setDecorators]=useState([]),[searchData,setSearchData]=useState(null),[loading,setLoading]=useState(false)
 const [booking,setBooking]=useState(null),[submitting,setSubmitting]=useState(false),[message,setMessage]=useState({type:'',text:''})

 const runSearch=async form=>{
  setLoading(true);setMessage({type:'',text:''});setSearchData(form)
  try{setDecorators(await searchDecorators(form))}
  catch(e){setMessage({type:'error',text:e.response?.data?.message||'Backend is not reachable. Start Spring Boot on port 8080.'})}
  finally{setLoading(false)}
 }
 const submitBooking=async form=>{
  setSubmitting(true);setMessage({type:'',text:''})
  try{const saved=await createBooking(form);setBooking(null);setMessage({type:'success',text:`Booking #${saved.id} submitted successfully!`});window.scrollTo({top:0,behavior:'smooth'})}
  catch(e){const er=e.response?.data?.errors;setMessage({type:'error',text:er?Object.values(er).join(' '):(e.response?.data?.message||'Booking failed.')})}
  finally{setSubmitting(false)}
 }
 return <div>
  <header className="navbar"><div className="brand"><div className="brand-icon">✿</div><div><strong>EventNest</strong><span>Decorations & Florals</span></div></div><div className="nav-badge">🌿 Local • Trusted • Creative</div></header>
  <main>
   <section className="hero"><div className="hero-content"><span className="eyebrow">✨ PLAN YOUR PERFECT EVENT</span><h1>Find the right decorator for your <span>special day.</span></h1><p>Compare local event decorators and florists by location, budget, service and availability — all in one place.</p></div><div className="hero-art"><div className="floating-card">💐 Floral<br/><b>Beautiful</b></div><div className="hero-circle">🎉</div><div className="floating-card second">💡 Lighting<br/><b>Creative</b></div></div></section>
   <section className="search-panel"><div className="section-heading"><div><span className="mini-label">SMART MATCHING</span><h2>Tell us what you need</h2></div><span className="step">01 / SEARCH</span></div><SearchForm onSearch={runSearch} loading={loading}/></section>
   {message.text&&<div className={'alert '+message.type}>{message.type==='success'?'🎉 ':'⚠️ '}{message.text}</div>}
   <section className="results-section"><div className="results-heading"><div><span className="mini-label">MATCHING RESULTS</span><h2>{searchData?`${decorators.length} Decorator${decorators.length===1?'':'s'} Found`:'Featured Local Decorators'}</h2></div>{searchData&&<span className="search-summary">{searchData.location} · Up to ₹{Number(searchData.budget).toLocaleString('en-IN')}</span>}</div>
    {!searchData&&<div className="empty-state"><div className="empty-icon">🔎</div><h3>Start your search</h3><p>Enter your event details above to see matching decorators.</p></div>}
    {searchData&&!loading&&!decorators.length&&<div className="empty-state"><div className="empty-icon">🌸</div><h3>No exact matches found</h3><p>Try increasing your budget or changing location/service.</p></div>}
    <div className="card-grid">{decorators.map(d=><DecoratorCard key={d.id} decorator={d} onBook={setBooking}/>)}</div>
   </section>
  </main>
  <footer><div><strong>EventNest</strong> — Local Event Decoration & Floral Aggregator</div><span>Hackathon Demo • Java + Spring Boot + React + MySQL</span></footer>
  {booking&&<BookingModal decorator={booking} searchData={searchData} onClose={()=>setBooking(null)} onSubmit={submitBooking} submitting={submitting}/>}
 </div>
}
