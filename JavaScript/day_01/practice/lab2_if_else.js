/*Bài 1: Viết function nhập vào biến mark có giá trị từ 0 -> 100. Kiểm tra giá trị của biến mark và in ra nội dụng sau

”A” nếu mark >= 85
”B” nếu 70 <= mark < 85 (70 <= mark && mark < 85)
”C” nếu 40 <= mark < 70 (40 <= mark && mark <70)
Các trường hợp còn lại in ra “D”
*/

let mark = prompt('Enter your mark: ');
if (mark >= 85) {
    console.log('A');
} else if (70 <= mark && mark < 85) {
    console.log('B');
} else if (40 <= mark && mark < 70) {
    console.log('C');
} else {
    console.log('D');
}



// Bài 2: Viết function truyền vào 2 số a, b. In ra màn hình số có giá trị lớn hơn

function max(a, b) {
    if (a > b) {
        console.log(a);
    } else {
        console.log(b);
    }
}


// Bài 3: Viết function nhập vào 1 số. Kiểm tra số đó là số âm, số dương hay là số 0.

function checkNumber(number) {
    if (number < 0) {
        console.log('Negative');
    } else if (number > 0) {
        console.log('Positive');
    } else {
        console.log('Zero');
    }
}


// Bài 4: Viết function nhập vào 1 số. Kiểm tra số đó là số chẵn hay số lẻ.




// Bài 5: Viết function nhập vào 1 số. Kiểm tra số đó có đồng thời chia hết cho 3 và 5 không.

function checkNumber(number) {
    if (number % 3 == 0 && number % 5 == 0) {
        console.log('Divisible by 3 and 5');
    } else {
        console.log('Not divisible by 3 and 5');
    }
}



// Bài 6: Viết function nhập vào 3 số a, b, c. Kiểm tra xem c có bằng a + b không?

let a = prompt('Enter a: ');
let b = prompt('Enter b: ');
let c = prompt('Enter c: ');
console.log ((a + b) == c); 
