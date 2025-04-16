// dropdown
let dropdown = document.querySelector(".dropdown");
let subList = document.querySelector(".sub_menu");
// console.log(dropdown);

dropdown.addEventListener("click", showSubList);

let cnt =0;
function showSubList(){
  // cnt++;

  // if(cnt%2 == 1){
  //   // subList.style.display = "block";
  //   subList.classList.remove("sub_menu");
  // } else{
  //   // subList.style.display = "none";
  //   subList.classList.add("sub_menu");
  // }
  
  //위의 if문과 동일
  subList.classList.toggle("display_none");

  console.log(cnt);
}


// slide
let liAll = document.querySelectorAll(".slides li");

setInterval(autoSlide, 2000); //3초마다 자동 실행

let index = 0;
function autoSlide(){
  index++;
  console.log(index);
  if(index>=liAll.length){
    index = 0;
  }

  liAll.forEach(function(slide){
    slide.style.transform = `translateX(${index*(-100)}%)`;
  })
}