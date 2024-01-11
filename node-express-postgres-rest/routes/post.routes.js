const Router = require('express');
const postController = require('../controller/post.controller');

const router = new Router();

router.post('/post/new', postController.createPost);
router.get('/posts', postController.getPosts);
router.get('/post', postController.getPostsByUser);
router.get('/post/:id', postController.getPost);
router.put('/post/:id', postController.updatePost);
router.delete('/post/:id', postController.deletePost);

module.exports = router;