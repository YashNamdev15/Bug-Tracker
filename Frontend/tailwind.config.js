module.exports = {
  content: [
    "./pages/*.{html,js}",
    "./index.html",
    "./components/**/*.{html,js}",
    "./src/**/*.{html,js}"
  ],
  darkMode: 'class',
  theme: {
    extend: {
      colors: {
        // Primary Colors - Confident Blue
        primary: {
          DEFAULT: '#2563EB', // blue-600
          50: '#EFF6FF', // blue-50
          100: '#DBEAFE', // blue-100
          200: '#BFDBFE', // blue-200
          300: '#93C5FD', // blue-300
          400: '#60A5FA', // blue-400
          500: '#3B82F6', // blue-500
          600: '#2563EB', // blue-600
          700: '#1D4ED8', // blue-700
          800: '#1E40AF', // blue-800
          900: '#1E3A8A', // blue-900
          foreground: '#FFFFFF', // white
        },
        // Secondary Colors - Balanced Slate
        secondary: {
          DEFAULT: '#475569', // slate-600
          50: '#F8FAFC', // slate-50
          100: '#F1F5F9', // slate-100
          200: '#E2E8F0', // slate-200
          300: '#CBD5E1', // slate-300
          400: '#94A3B8', // slate-400
          500: '#64748B', // slate-500
          600: '#475569', // slate-600
          700: '#334155', // slate-700
          800: '#1E293B', // slate-800
          900: '#0F172A', // slate-900
          foreground: '#FFFFFF', // white
        },
        // Accent Colors - Energetic Sky Blue
        accent: {
          DEFAULT: '#0EA5E9', // sky-500
          50: '#F0F9FF', // sky-50
          100: '#E0F2FE', // sky-100
          200: '#BAE6FD', // sky-200
          300: '#7DD3FC', // sky-300
          400: '#38BDF8', // sky-400
          500: '#0EA5E9', // sky-500
          600: '#0284C7', // sky-600
          700: '#0369A1', // sky-700
          800: '#075985', // sky-800
          900: '#0C4A6E', // sky-900
          foreground: '#FFFFFF', // white
        },
        // Background
        background: {
          DEFAULT: '#FAFAFA', // neutral-50
          foreground: '#0F172A', // slate-900
        },
        // Surface
        surface: {
          DEFAULT: '#FFFFFF', // white
          foreground: '#1E293B', // slate-800
        },
        // Text Colors
        text: {
          primary: '#0F172A', // slate-900
          secondary: '#64748B', // slate-500
        },
        // Status Colors
        success: {
          DEFAULT: '#059669', // emerald-600
          50: '#ECFDF5', // emerald-50
          100: '#D1FAE5', // emerald-100
          500: '#10B981', // emerald-500
          600: '#059669', // emerald-600
          700: '#047857', // emerald-700
          foreground: '#FFFFFF', // white
        },
        warning: {
          DEFAULT: '#D97706', // amber-600
          50: '#FFFBEB', // amber-50
          100: '#FEF3C7', // amber-100
          500: '#F59E0B', // amber-500
          600: '#D97706', // amber-600
          700: '#B45309', // amber-700
          foreground: '#FFFFFF', // white
        },
        error: {
          DEFAULT: '#DC2626', // red-600
          50: '#FEF2F2', // red-50
          100: '#FEE2E2', // red-100
          500: '#EF4444', // red-500
          600: '#DC2626', // red-600
          700: '#B91C1C', // red-700
          foreground: '#FFFFFF', // white
        },
        // Border Colors
        border: {
          light: '#E2E8F0', // slate-200
          medium: '#CBD5E1', // slate-300
          DEFAULT: '#E2E8F0', // slate-200
        },
      },
      fontFamily: {
        heading: ['Outfit', 'sans-serif'],
        body: ['Source Sans 3', 'sans-serif'],
        caption: ['Inter', 'sans-serif'],
        mono: ['JetBrains Mono', 'monospace'],
        sans: ['Source Sans 3', 'sans-serif'],
      },
      fontSize: {
        'xs': ['0.75rem', { lineHeight: '1.4' }],
        'sm': ['0.875rem', { lineHeight: '1.4' }],
        'base': ['1rem', { lineHeight: '1.6' }],
        'lg': ['1.125rem', { lineHeight: '1.5' }],
        'xl': ['1.25rem', { lineHeight: '1.4' }],
        '2xl': ['1.5rem', { lineHeight: '1.3' }],
        '3xl': ['1.875rem', { lineHeight: '1.25' }],
        '4xl': ['2.25rem', { lineHeight: '1.2' }],
      },
      spacing: {
        'xs': '6px',
        'sm': '12px',
        'md': '18px',
        'lg': '24px',
        'xl': '32px',
        '2xl': '48px',
        '3xl': '64px',
        '4xl': '80px',
        '5xl': '120px',
      },
      borderRadius: {
        'sm': '6px',
        'md': '10px',
        'lg': '14px',
        'xl': '20px',
        'DEFAULT': '10px',
      },
      boxShadow: {
        'sm': '0 1px 2px rgba(15, 23, 42, 0.08)',
        'DEFAULT': '0 1px 3px rgba(15, 23, 42, 0.10), 0 1px 2px rgba(15, 23, 42, 0.06)',
        'md': '0 4px 6px -1px rgba(15, 23, 42, 0.10), 0 2px 4px -1px rgba(15, 23, 42, 0.08)',
        'lg': '0 10px 15px -3px rgba(15, 23, 42, 0.12), 0 4px 6px -2px rgba(15, 23, 42, 0.10)',
        'xl': '0 20px 25px -5px rgba(15, 23, 42, 0.15), 0 10px 10px -5px rgba(15, 23, 42, 0.12)',
        'none': 'none',
      },
      transitionDuration: {
        '250': '250ms',
      },
      transitionTimingFunction: {
        'smooth': 'cubic-bezier(0.4, 0, 0.2, 1)',
      },
      animation: {
        'pulse': 'pulse 2s cubic-bezier(0.4, 0, 0.6, 1) infinite',
      },
      keyframes: {
        pulse: {
          '0%, 100%': { opacity: '1' },
          '50%': { opacity: '0.5' },
        },
      },
      zIndex: {
        '1': '1',
        '10': '10',
        '50': '50',
        '100': '100',
        '200': '200',
        '300': '300',
      },
      maxWidth: {
        'prose': '70ch',
      },
      gap: {
        'grid': '20px',
      },
      height: {
        'button': '48px',
        'input': '48px',
        'table-row': '56px',
      },
      minHeight: {
        'touch': '44px',
      },
      minWidth: {
        'touch': '44px',
      },
    },
  },
  plugins: [],
}