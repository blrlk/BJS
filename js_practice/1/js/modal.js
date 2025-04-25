let open = document.querySelector('.open');
let close = document.querySelector('.close');
let modal = document.querySelector(".modalView");
let modalContent = document.querySelector(".modalcontent");

open.addEventListener("click", function () {
  modal.style.display = "block";
});

close.addEventListener("click", function () {
  modal.style.display = "none";
})

modal.addEventListener("click", function (event) {
  // // 얘는 modalContent의 자식을 클릭해도 닫힘
  // if(!(event.target === modalContent)){
  //   modal.style.display = "none";
  // }

  // 클릭한 요소가 다른 요소의 자식 요소인지 여부 확인
  if(!modalContent.contains(event.target)){
    modal.style.display = "none";
  }
});