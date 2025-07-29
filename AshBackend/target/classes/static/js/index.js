
document.addEventListener('DOMContentLoaded',function()
{
    document.getElementById('login_form').addEventListener('submit',async function(e)
    {
        e.preventDefault();

        const rawuser = document.getElementById('username').value;
        const rawpass = document.getElementById('password').value;

        const sanuser = DOMPurify.sanitize(rawuser);
        const sanpass = DOMPurify.sanitize(rawpass);

        await fetch("http://localhost:8080/waf/login",{
            method : "POST",
            headers:{"Content-Type" : "application/json"},
			body: JSON.stringify({
			  requestURI: "/login",
			  method: "POST",
			  source: "127.0.0.1", 
			  userAgent: navigator.userAgent,
			  payload: JSON.stringify({
			    email: sanuser,
			    pass: sanpass
			  })
			})
        })
		.then(async response => {
		    const redirectUrl = await response.text();
		    window.location.href = redirectUrl;
		});
    });
});