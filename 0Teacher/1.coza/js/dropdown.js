let home = document.querySelector(".menu_home");
console.log(home);
let submenu = document.querySelector(".submenu");
// console.log(submenu);
home.addEventListener("click", showList);

let clickCount = 0;
function showList() {
  // submenu.classList.toggle("show");
  clickCount++;
  if (clickCount % 2 == 1) {
    submenu.style.display = "block";
  } else {
    submenu.style.display = "none";
  }
}
