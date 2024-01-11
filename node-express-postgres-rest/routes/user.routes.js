const Router = require('express');
const userController = require('../controller/user.controller');

const router = new Router();

router.post('/user/new', userController.createUser);
router.get('/users', userController.getUsers);
router.get('/user/:id', userController.getUser);
router.put('/user/update/:id', userController.updateUser);
router.delete('/user/delete/:id', userController.deleteUser);

module.exports = router;