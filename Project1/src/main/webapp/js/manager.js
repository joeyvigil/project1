

window.onload = function(){
	
	getTickets();
}

function getTickets() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status==200){
//------------------------------------------------
			let text = JSON.parse(xhttp.responseText);
			console.log(text);
			i=1;
			for(t of text){
				if(t.status_fk.status=="Pending"){
				
					newrow = document.getElementById("pending").appendChild(document.createElement("tr"));
					newrow.setAttribute("id", `row${i}`);
					tr= document.getElementById(`row${i}`)
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_id;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_amount;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_submit;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_resolved;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_description;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.author_fk.user_name;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					if(!t.resolver_fk==null){
					tdtemp.innerHTML=t.resolver_fk.user_name;
					}
					
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.type_fk.type;
					
					
				}
				i++;
			}
			
		
			for(t of text){
				
				if(t.status_fk.status=="Approved"){
				//console.log(t);
					newrow = document.getElementById("approved").appendChild(document.createElement("tr"));
					newrow.setAttribute("id", `row${i}`);
					tr= document.getElementById(`row${i}`)
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_id;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_amount;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_submit;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_resolved;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_description;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.author_fk.user_name;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.resolver_fk.user_name;
					
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.type_fk.type;
					
				}
				i++;
			}
			

			for(t of text){
				
				if(t.status_fk.status=="Denied"){
				//console.log(t);
					newrow = document.getElementById("denied").appendChild(document.createElement("tr"));
					newrow.setAttribute("id", `row${i}`);
					tr= document.getElementById(`row${i}`)
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_id;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_amount;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_submit;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_resolved;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.reimb_description;
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.author_fk.user_name;
				
			
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.resolver_fk.user_name;
					
					tdtemp = tr.appendChild(document.createElement("td"));
					tdtemp.innerHTML=t.type_fk.type;
					
				}
				i++;
			}
	
	
//----------------------------------------------------------------------
		}
	}
	
	xhttp.open("GET", "http://localhost:8080/Project1/gettext.json");
	xhttp.send();
}

