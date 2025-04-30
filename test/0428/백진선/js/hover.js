let detail = document.querySelector(".detail");
let contentdetail = document.querySelector('.contentDetail');

console.log(detail);

detail.addEventListener("mouseover", function(){
  contentdetail.style.display = "block";
}); 

detail.addEventListener("mouseout", function(){
  contentdetail.style.display = "none";
}); 