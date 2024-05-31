const randomNumber = Math.floor(Math.random() * 100) + 1;

let attempts = 0;

function checkGuess() {
    const userGuess = parseInt(document.getElementById('userGuess').value);

    if (isNaN(userGuess) || userGuess < 1 || userGuess > 100) {
        alert('Please enter a valid number between 1 and 100.');
        return;
    }

    attempts++;

    if (userGuess === randomNumber) {
        displayResult(`Congratulations! You guessed the correct number (${randomNumber}) in ${attempts} attempts.`);
        resetGame();
    } else if (userGuess < randomNumber) {
        displayResult(`Too low! Try again.`);
    } else {
        displayResult(`Too high! Try again.`);
    }

    document.getElementById('attempts').textContent = `Attempts: ${attempts}`;
}

function displayResult(message) {
    document.getElementById('result').textContent = message;
}

function resetGame() {
    attempts = 0;
    randomNumber = Math.floor(Math.random() * 100) + 1;
}
