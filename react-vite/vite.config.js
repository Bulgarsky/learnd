import react from '@vitejs/plugin-react';

import { defineConfig } from 'vite';

//import legacy from "@vitejs/plugin-legasy";

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [react()],
        // legacy({
        //     targets: ["IE >= 11"],
        //     additionalLegacyPolyfills: ["whatwg-fetch"]
        //        })
});
