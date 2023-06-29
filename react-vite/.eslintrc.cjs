module.exports = {
  env: { browser: true, es2020: true },
  extends: [
    'eslint:recommended',
    'plugin:react/recommended',
    'plugin:react/jsx-runtime',
    'plugin:react-hooks/recommended',
  ],
  parserOptions: { ecmaVersion: 'latest', sourceType: 'module' },
  settings: { react: { version: '18.2' } },
  plugins: ['react-refresh'],
  rules: {
    'react-refresh/only-export-components': 'warn',
    // "no-unused-vars": "warn",
    // "no-console": "warn",
    // "prefer-const": "error",
    // "quotes": ["error", "double"],
    // "jsx-quotes": ["error", "prefer-double"],
    // "indent": ["warn", 2],
    // "max-len": ["error", {"code":  120}],
    // // "comma-dangle": ["error", "always-multiline"],
    // "semi": ["warn", "always"],
    // "import/order": ["warn" , {
    //   "groups":[
    //     "builtin", "external", "internal", "parent", "sibling", "index", "object", "style"
    //   ],
    //   "newlines-between": "always-and-inside-groups"
    // }]
  },
}
