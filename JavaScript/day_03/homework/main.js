// 1. Highlight tất cả các từ có độ dài lớn hơn hoặc bằng 5 ký tự trong đoạn văn (background = “yellow”)

const text = document.querySelector('p').textContent;
const words = text.split(' ');

words.forEach(word => {
  if (word.length >= 5) {
    document.querySelector('p').innerHTML = document.querySelector('p').innerHTML.replace(word, `<span style="background: yellow;">${word}</span>`);
  }
});

// 2. Thêm link hiển thị text “facebook” link đến trang facebook.com ở sau thẻ p

document.body.innerHTML += `<a href="https://www.facebook.com/">Facebook</a>`;

// 3. Đếm số từ có trong đoạn văn. Tạo 1 thẻ div để hiển thị số từ

const wordCount = words.length;
document.body.innerHTML += `<div><br>Số từ: ${wordCount}</div>`;

// 4. Thay thế ký hiệu "," => 🤔 và "." => 😲

document.querySelector('p').innerHTML = document.querySelector('p').innerHTML.replace(/,/g, '🤔').replace(/\./g,'😲');