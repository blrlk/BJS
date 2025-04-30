let btndropdown = document.querySelector(".btnDropdown");
let submenu = document.querySelector(".subMenu");

btndropdown.addEventListener("click", function(){
  submenu.classList.toggle("showDropdown");
  btndropdown.classList.toggle("menucss");
});