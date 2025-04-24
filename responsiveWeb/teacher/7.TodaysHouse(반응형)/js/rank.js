const rankDiv = document.querySelector('.rank');
const rankBtn = document.querySelector('.rank i');

let isExpanded = false;

rankBtn.addEventListener('click', function() {
  isExpanded = !isExpanded;

  if (isExpanded) {
    rankDiv.classList.add('expand');
    rankBtn.classList.remove('fa-chevron-down');
    rankBtn.classList.add('fa-chevron-up');
  } else {
    rankDiv.classList.remove('expand');
    rankBtn.classList.remove('fa-chevron-up');
    rankBtn.classList.add('fa-chevron-down');
  }
});

