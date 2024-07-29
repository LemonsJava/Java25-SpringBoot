// Tao du lieu

const questions = [
  { id: 1, title: "1 + 1 = ?", choices: [1, 2, 3, 4, 5], answer: 2 },
  {
    id: 2,
    title: "Nam 2024 co phai la nam nhuan khong?",
    choices: [true, false],
    answer: true,
  },
  {
    id: 3,
    title: "Thang 2 nam 2024 co 28 ngay?",
    choices: [true, false],
    answer: false,
  },
  {
    id: 4,
    title: "Viet Nam co bao nhieu tinh va thanh pho?",
    choices: [60, 61, 62, 63, 64],
    answer: 63,
  },
];

let currentQuestionIndex = 0;
let counterAnswer = 0;

const btnNextQuestion = document.querySelector("#btn-next");
const btnFinish = document.querySelector("#btn-finish");

const renderQuestion = () => {
  const question = questions[currentQuestionIndex]; // cau hoi hien tai theo index

  // Hien thi tieu de cau hoi
  const titleEl = document.querySelector("#question p");
  titleEl.innerHTML = `Cau ${currentQuestionIndex + 1}: ${question.title}`;

  // Hien thi cac lua chon
  const choiceEl = document.querySelector(".choices");
  let html = "";
  question.choices.forEach((choice, index) => {
    // Duyet mang choice trong cau hoi hien tai
    html += `
    <div class="choice-item">
        <input type="radio" name="choice" id="${index}" value="${choice}" />
        <label for="${index}">${choice}</label>
    </div>
    `;
  });
  choiceEl.innerHTML = html;

  // Doi nut NextQuestion thanh Finish
  if (currentQuestionIndex === questions.length - 1) {
    btnNextQuestion.classList.add("hide"); // Them class "hide" vao btnNextQuestion
    btnFinish.classList.remove("hide"); // Neu da co class "hide" thi xoa di
  }
};

// Kiem tra dap an
const checkAnswer = () => {
  const correctAnswer = String(questions[currentQuestionIndex].answer);
  const selectedChoice = document.querySelector('input[name="choice"]:checked');
  if (selectedChoice) {
    const selectAnswer = selectedChoice.value;
    if (selectAnswer === correctAnswer) {
      counterAnswer++;
    }
    return true; // Da chon cau tra loi
  }
  return false; // Chua chon cau tra loi
};

// Hien thi cau tiep theo
btnNextQuestion.addEventListener("click", () => {
  if (checkAnswer()) {
    currentQuestionIndex++;
    renderQuestion();
  } else {
    alert("Ban chua chon dap an");
  }
});

// Thong bao ket qua
btnFinish.addEventListener("click", () => {
  if (checkAnswer()) {
    alert(`Ban da tra loi dung ${counterAnswer}/${questions.length} cau`);
    window.location.reload();
  } else {
    alert("Ban chua chon dap an");
  }
});

renderQuestion();
