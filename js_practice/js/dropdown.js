let main = document.querySelectorAll(".main > div");
let sub = document.querySelectorAll(".main .sub");

main.forEach(function(mains){
  mains.addEventListener("click", dropdowning);
})

function dropdowning(){
  // // 하나만 dropdown
  // sub.forEach(function(subs){
  //   subs.classList.remove("show");
  // })

  let subshow = document.querySelector("." + this.id);

  if(subshow){
    subshow.classList.toggle("show");
  }
}