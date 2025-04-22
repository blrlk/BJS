let tabbtn = document.querySelectorAll(".tabbtn > button");
let tabcontent = document.querySelectorAll(".content");

tabbtn.forEach(function(tab){
  tab.addEventListener("click", tabshow);
})

showContent("content");
tabDeco("content");

function tabshow(){
  let crntID = this.id;
  console.log(crntID);

  showContent(crntID);
  tabDeco(crntID);
}

function showContent(crntID){
  let contents = document.querySelectorAll("." + crntID);
  console.log(contents);

  tabcontent.forEach(function(content){
    content.classList.remove("show");
  })

  contents.forEach(function(content){
    content.classList.add("show");
  })
}

function tabDeco(crntID){
  tabbtn.forEach(function(tab){
    tab.style.backgroundColor = "yellowgreen";
  })
  let crntTab = document.querySelector("#" + crntID);
  crntTab.style.backgroundColor = "yellow";
}