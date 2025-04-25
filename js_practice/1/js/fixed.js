let header = document.querySelector("#fixed");
let offset = header.offsetHeight;

window.addEventListener("scroll", function(){
  if(this.window.scrollY > offset){
    header.classList.add("scrolled");
  } else{
    header.classList.remove("scrolled");
  }
});