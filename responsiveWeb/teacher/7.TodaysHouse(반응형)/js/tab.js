let btns = document.querySelectorAll("#best button");
let contents = document.querySelectorAll("#best .all")
btns.forEach(function (btn) {
  btn.addEventListener("click", function(){
    showTabContents(this.id);
  });
  btn.addEventListener("click", function(){
    changeColor(this);
  });
});

showTabContents("all");
changeColor(btns[0]);

function showTabContents(id) {
  let activeContents = document.querySelectorAll("." + id);

  contents.forEach(function (content) {
    content.classList.remove("active");
  })

  activeContents.forEach(function(active){
    active.classList.add("active");
  });
}

function changeColor(item){
  btns.forEach(function (btn) {
    btn.classList.remove("active");
  })

  item.classList.add("active");
}
