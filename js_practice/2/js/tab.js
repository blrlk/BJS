let tabbtn = document.querySelectorAll(".tabbtn > button");
let tabcontent = document.querySelectorAll(".all");

tabbtn.forEach(function(btn){
  btn.addEventListener("click", show);
});

showContent("all");
changeTab("all");

function show(){
  let crntID = this.id;
  console.log(crntID);

  showContent(crntID);
  changeTab(crntID);
}

function showContent(crntID){
  tabcontent.forEach(function(content){
    content.classList.remove("show");
  })

  let now = document.querySelectorAll("." + crntID);
  console.log(now);

  now.forEach(function(content){
    content.classList.add("show");
  })
}

function changeTab(crntID){
  let now = document.querySelector("#" + crntID);
  tabbtn.forEach(function(btn){
    btn.classList.remove("tabbtncss");
  });

  now.classList.add("tabbtncss");
}