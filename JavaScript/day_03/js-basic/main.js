// Truy cập vào thẻ h1 có id=“heading” thay đổi màu chữ thành ‘red’, và in hoa nội dung của thẻ đó

document.getElementById('heading').style.color ='red';
document.getElementById('heading').style.textTransform = 'uppercase';

// Thay đổi màu chữ của tất cả thẻ có class “para” thành màu “blue” và có font-size = “20px”
const paras = document.querySelectorAll('.para');
for (const para of paras) {
    para.style.color = 'blue';
    para.style.fontSize = '20px';
}

// paras.forEach(element => {
//     element.style.color = 'blue';
//     element.style.fontSize = '20px';
// });


// Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”

const link = document.createElement('a');
link.href = 'https://facebook.com';
link.innerText = 'Facebook';

const contentEl = document.querySelector('.content');
document.body.insertBefore(link, contentEl);
link.style.fontSize = '20px';


// Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”
document.getElementById('title').innerText = 'Đây là thẻ tiêu đề';

// Thêm class “text-bold” vào thẻ có class=“description” (định nghĩa class “text-bold” có tác dụng in đậm chữ)

document.querySelector('.description').classList.add('text-bold');

// Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”

const button = document.createElement('button');
button.innerText = 'Click me';
button.style.fontSize = '20px';
const para3 = document.querySelector('.para-3');
document.body.replaceChild(button, para3);


// Copy thẻ có class=“para-2” và hiển thị ngay đằng sau thẻ đó

const para2 = document.querySelector('.para-2');
const clonedPara2 = para2.cloneNode(true);
document.body.insertBefore(clonedPara2, button);



// Xóa thẻ có class=“para-1”

const para1 = document.querySelector('.para-1');
para1.remove();

// Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn). Yêu cầu

// Đặt màu văn bản thành #777
// Đặt kích thước phông chữ thành 2rem
// Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.

