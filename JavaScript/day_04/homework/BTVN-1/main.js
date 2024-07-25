//Giá trị mặc định của counter ban đầu = 0
// Bấm vào Cộng tăng counter lên 1
// Bấm vào Trừ giảm counter đi 1
// Nếu counter > 0 có màu green
// Nếu counter = 0 có màu #333333
// Nếu counter < 0 có màu red

const counterELe = document.querySelector('#counter');
const btnIncrease = document.getElementById('nextBtn');
const btnDecrease = document.getElementById('prevBtn');

let counter = 0;

btnIncrease.addEventListener("click", () => {
    counter++;
    counterELe.innerHTML = `${counter}`;
    if (counter > 0) {
        counterELe.style.color = 'green';
    } else if (counter < 0) {
        counterELe.style.color = 'red';
    } else {
        counterELe.style.color = '#333333';
    }
});

btnDecrease.addEventListener("click", () => {
    counter --;
    counterELe.innerHTML = `${counter}`;
    if (counter > 0) {
        counterELe.style.color = 'green';
    } else if (counter < 0) {
        counterELe.style.color = 'red';
    } else {
        counterELe.style.color = '#333333';
    }
});