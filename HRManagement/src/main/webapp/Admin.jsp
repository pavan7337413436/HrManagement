<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-image: url("http://www.pixelstalk.net/wp-content/uploads/2016/07/Desktop-Best-Plain-Photos.jpg");
    background-size: cover;
    background-position: center;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    color: #fff;
}

h1 {
    text-align: center;
    margin-bottom: 20px;
}

.card {
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    padding: 20px;
    margin-bottom: 20px;
}

.card h2 {
    margin-bottom: 10px;
}

.card p {
    margin-bottom: 20px;
}

.button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    text-decoration: none;
}

.button:hover {
    background-color: #0056b3;
}

.dashboard-buttons {
    text-align: center;
}

</style>
</head>
<body>
<div class="container">
    <h1>Hello, Welcome To Admin Dashboard</h1>
    <div class="card">
        <h2>Recent Users Report</h2>
        <p>Display a summary of recent user activities, registrations, etc. here.</p>
        <div class="dashboard-buttons">
            <button class="button"><a href="ViewServlet">View All Users Report</a></button>
            <button class="button"><a href="registration.html">Add Users</a></button>
            <button class="button"><a href="search.html">Search User Details</a></button>
            <button class="button"><a href="delete.html">Delete User</a></button>
            <button class="button"><a href="update.html">Update Employee Details</a></button>
        </div>
                    <button class="button"><a href="login.html">Back To Login</a></button>
        
    </div>
    
    <div class="card">
        <h2>Real-time Notifications</h2>
        <p>Display real-time notifications about system events, user activities, etc. here.</p>
        <div class="notifications">
            <!-- Notifications will be dynamically added here using JavaScript -->
        </div>
    </div>
</div>

<script>
setTimeout(() => {
    const notificationsContainer = document.querySelector('.notifications');
    const notifications = [
        'New user registered',
        'Server maintenance scheduled for tomorrow',
        'Database backup completed successfully'
    ];

    notifications.forEach(notification => {
        const p = document.createElement('p');
        p.textContent = notification;
        notificationsContainer.appendChild(p);
    });
}, 3000); 
</script>
</body>
</html>
