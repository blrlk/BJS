let hTop = document.querySelector("#h_top");
let hBottom = document.querySelector("#h_bottom");
let offset = hTop.offsetHeight;
console.log(offset);

window.addEventListener("scroll", function(){
  if(this.window.scrollY > offset){
    hBottom.classList.add("fixed");
  } else{
    hBottom.classList.remove("fixed");
  }
});