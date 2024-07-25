// Yêu cầu 1:
// Khi nhấn vào button “Change content” hiển thị một nội dung quote bất kỳ


// Yêu cầu 2:
// Khi nhấn vào button “Change color” thì thay đổi màu của thẻ p (sử dụng màu HEX - cần viết 1 function để random màu HEX)

const randomColor = () => {
    const r = Math.floor(Math.random() * 256);
    console.log("r: ", r);
    const g = Math.floor(Math.random() * 256);
    console.log("g: ", g);
    const b = Math.floor(Math.random() * 256);
    console.log("b: ", b);
    return  `#${r.toString(16)}${g.toString(16)}${b.toString(16)}`;

}

const button2 = document.querySelector('#btn-2');
const pEl = document.querySelector('p');
button2.addEventListener('click', () => {
    pEl.style.color = randomColor();
});

// Yêu cầu 3:
// Khi nhấn vào button “Change background” thì thay đổi màu background-color của thẻ p (sử dụng màu RGB - cần viết 1 function để random màu RGB)

const randomRGB = () => {
    const r = Math.floor(Math.random() * 256);
    const g = Math.floor(Math.random() * 256);
    const b = Math.floor(Math.random() * 256);
    return `rgb(${r}, ${g}, ${b})`;
}

const button3 = document.querySelector('#btn-3');
button3.addEventListener('click', () => {
    pEl.style.backgroundColor = randomRGB();
});