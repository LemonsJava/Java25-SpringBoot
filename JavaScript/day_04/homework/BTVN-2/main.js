// Khi người dùng nhập password và bấm nút “Show”, lúc này hiển thị password và nội dung button chuyển từ “Show” --> “Hide”
// Ngược lại khi người dùng bấm vào nút “Hide”, lúc này ẩn password và nội dung button chuyển từ “Hide” --> “Show”
// Nếu làm được Show - Hide button -> chuyển qua làm với icon : https://fontawesome.com/search?q=eye&o=r&m=free

const passwordInput = document.getElementById('input-password');
const showHideButton = document.getElementById('show-hide-btn');

showHideButton.addEventListener('click', () => {
  if (passwordInput.type === 'password') {
    passwordInput.type = 'text'; //  Password is visible
    showHideButton.innerText = "Hide";
  } else {
    passwordInput.type = 'password'; // Password is not visible
    showHideButton.innerText = "Show";
  }
});
