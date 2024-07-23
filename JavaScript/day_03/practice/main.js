// Câu 1. Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn). Yêu cầu
// Đặt màu văn bản thành #777
// Đặt kích thước phông chữ thành 2rem
// Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.

const para = document.getElementById('text');
para.style.color = '#777';
para.style.fontSize = '2rem';
para.innerHTML = 'Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript';

// Câu 2. Sử dụng vòng lặp để đặt màu chữ cho tất cả thẻ li thành màu blue (tạo thẻ ul-li bằng html)

const ul = document.querySelector('ul');
for (const li of ul.children) {
    li.style.color = 'blue';
}

// Sử dụng javascript để thực hiện những công việc sau
// Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
const li8 = document.createElement('li');
// li8.innerText = 'Item 8';

// const li9 = document.createElement('li');
// li9.innerText = 'Item 9';

// const li10 = document.createElement('li');
// li10.innerText = 'Item 10';

const list = document.getElementById('list');
// list.appendChild(li8);
// list.appendChild(li9);
// list.appendChild(li10);

for (let i = 8; i < 11; i++) {
    const li = document.createElement('li');
    li.innerText = `Item ${i}`;
    list.appendChild(li);
}


{/* <ul id="list">
        <li>Item 1</li>
        <li>Item 2</li>
        <li>Item 3</li>
        <li>Item 4</li>
        <li>Item 5</li>
        <li>Item 6</li>
        <li>Item 7</li>
     </ul> */}
// Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color)

const li1 = document.querySelector('#list li');
li1.style.color = 'red';

// Sửa background cho thẻ <li> 3 thành màu xanh (background-color)

const li3 = document.querySelector('#list li:nth-child(3)');
li3.style.backgroundColor = 'green';


// Remove thẻ <li> 4

const li4 = document.querySelector('#list li:nth-child(4)');
li4.parentElement.removeChild(li4);

// Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ

const newItem = document.createElement('li');
newItem.innerText = 'New Item';

li3.insertAdjacentElement('afterend', newItem);

// c2
 li3.insertAdjacentHTML('afterend', '<li>New Item 2</li>');