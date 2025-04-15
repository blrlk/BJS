let dropdown = document.querySelector(".main_menu");
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

  
  subList.classList.toggle("display_none");

  console.log(cnt);
}