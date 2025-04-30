let tabbtn = document.querySelectorAll(".tabbtn > button");
let tabcontent = document.querySelectorAll(".all");

tabbtn.forEach(function(btn){
  btn.addEventListener("click", show);
});

showContent("all");
chgbtn("all");

function show(){
  let crntID = this.id;

  showContent(crntID);
  chgbtn(crntID);
}

function showContent(crntID){
  let nowContent = document.querySelectorAll("." + crntID);
  
  tabcontent.forEach(function(content){
    content.style.display = "none";
  })

  nowContent.forEach(function(content){
    content.style.display = "block";
  })
}

function chgbtn(crntID){
  let nowBtn = document.querySelector("#" + crntID);
  tabbtn.forEach(function(btn){
    btn.style.backgroundColor = "transparent";
  })

  nowBtn.style.backgroundColor = "var(--pointcolor)";
}