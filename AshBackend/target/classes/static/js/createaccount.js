
document.addEventListener("DOMContentLoaded",function()
{
    document.getElementById('form_js').addEventListener("submit",async function(e)
    {
		e.preventDefault();

		const rawuser = document.getElementById("username").value; 
		const rawemail = document.getElementById("emailid").value; 
		const rawpass = document.getElementById("passwd").value; 
		const rawcpass = document.getElementById("cpasswd").value; 

		const user = DOMPurify.sanitize(rawuser);
		const email = DOMPurify.sanitize(rawemail);
		const pass = DOMPurify.sanitize(rawpass);
		const cpass = DOMPurify.sanitize(rawcpass);

		console.log("Sending password:", pass);
		
		await fetch("http://localhost:8080/waf/register",{
		            method : "POST",
		            headers:{"Content-Type" : "application/json"},
					body: JSON.stringify({
					  requestURI: "/register",
					  method: "POST",
					  source: "127.0.0.1", 
					  userAgent: navigator.userAgent,
					  payload: JSON.stringify({
					    user: user,
					    email: email,
						pass:pass
					  })
					})
		        })
		        .then(async response => {
					const message = await response.text();
					if(response.ok)
						{
							window.location.href=message;
						}
						else{
							window.location.href=message;
						}
				})
    });
});