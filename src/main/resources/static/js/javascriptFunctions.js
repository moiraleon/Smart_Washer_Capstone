async function postData(){
const response = await fetch('/start-wash',{
method: 'POST',
 cache: 'no-cache',
  headers: {
       'Content-Type': 'application/json'},
       redirect: 'follow'
});

 return response.json();
}

async function insufficientDetergentAlert(){
alert("Wash not completed. Insufficient detergent");
}
