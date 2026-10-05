export default function DecoratorCard({decorator,onBook}){
 return <article className="decorator-card">
  <img className="decorator-image" src={decorator.imageUrl} alt={decorator.businessName}
    onError={e=>e.currentTarget.style.display='none'}/>
  <div className="card-content">
   <div className="card-top"><span className="rating">⭐ {decorator.rating}</span><span className={decorator.available?'available':'unavailable'}>{decorator.available?'● Available':'● Busy'}</span></div>
   <h3>{decorator.businessName}</h3><p className="muted">📍 {decorator.location} · {decorator.ownerName}</p>
   <div className="tags">{decorator.services.split(',').slice(0,4).map(t=><span key={t}>{t.trim()}</span>)}</div>
   <div className="price-row"><div><small>Starting from</small><strong>₹{Number(decorator.startingPrice).toLocaleString('en-IN')}</strong></div><a className="call-link" href={'tel:'+decorator.phone}>📞 Call</a></div>
   <div className="card-actions"><a className="secondary-btn" href={decorator.portfolioUrl} target="_blank" rel="noreferrer">View Portfolio</a><button className="primary-btn" onClick={()=>onBook(decorator)}>Book Now</button></div>
  </div>
 </article>
}
